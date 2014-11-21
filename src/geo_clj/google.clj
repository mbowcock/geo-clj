(ns geo-clj.google
  (:require [clj-http.client :as client])
  (:require [clojure.data.json :as json]))

;; populate with google api key 
;; todo - ** change to pass from environment
(def apikey "***")
(def url "https://maps.googleapis.com/maps/api/geocode/json")

;; todo - remove url from here
(defn geocode [address apikey]
  "Uses google geocode api to geocode address. Returns lat / lng."
  (:location
    (:geometry 
      (first 
        (:results 
          (json/read-str
            (:body
              (client/get url
                          {:query-params {"key" apikey "address" address}})) :key-fn keyword))))))
