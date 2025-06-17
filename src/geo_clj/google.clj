(ns geo-clj.google
  (:require [clj-http.client :as client])
  (:require [clojure.data.json :as json]))

(def url "https://maps.googleapis.com/maps/api/geocode/json")

(defn geocode [address]
  "Uses google geocode api to geocode address. Returns lat / lng."
  (let [apikey (System/getenv "GOOGLE_APIKEY")
        data (:body (client/get url {:query-params {"key" apikey "address" address}}))
        json-data (json/read-str data :key-fn keyword)]
    (->>
     json-data
     :results
     first
     :geometry
     :location)))