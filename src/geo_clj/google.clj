(ns geo-clj.google
  (:require [clj-http.client :as client])
  (:require [clojure.data.json :as json]))

(def url "https://maps.googleapis.com/maps/api/geocode/json")

;; todo - remove url from here
(defn geocode [address]
  "Uses google geocode api to geocode address. Returns lat / lng."
  (let [apikey (System/getenv "GOOGLE_APIKEY")]
        (:location
          (:geometry 
            (first 
              (:results 
                (json/read-str
                  (:body
                    (client/get url
                                {:query-params {"key" apikey "address" address}})) :key-fn keyword)))))))
