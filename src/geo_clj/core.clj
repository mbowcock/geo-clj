(ns geo-clj.core
  (:gen-class)
  (:require [geo-clj.google :as goog]))

(defn -main 
  [& args]
  (println (goog/geocode "Fairhaven Highschool, Fairhaven MA, 02719"))
)
