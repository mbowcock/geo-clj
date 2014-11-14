(ns geo-clj.core
  (:require [clj-http.client :as client])
  (:require [clojure.data.json :as json]))

;; populate with google api key 
;; ** change to pass from environment
(def apikey "****")
(def url "https://maps.googleapis.com/maps/api/geocode/json")

(defn google-geocode [address apikey]
  "Uses google geocode api to geocode address"
(client/get url
    {:query-params {"key" apikey "address" address}}))
