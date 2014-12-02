(ns geo-clj.distance)

(defn simple 
  "Simple distance calculation. Assumed the earth is a perfect sphere.
  Should only be used for calculations where the distance is small.
  Results are returned in meters."
  [p1 p2]
  (let [pk (/ 180 java.lang.Math/PI)
        a1 (/ (:lat p1) pk)
        a2 (/ (:lng p1) pk)
        b1 (/ (:lat p2) pk)
        b2 (/ (:lng p2) pk)
        x (* (java.lang.Math/cos a1) (java.lang.Math/cos a2)
             (java.lang.Math/cos b1) (java.lang.Math/cos b2))
        y (* (java.lang.Math/cos a1) (java.lang.Math/sin a2)
             (java.lang.Math/cos b1) (java.lang.Math/sin b2))
        z (* (java.lang.Math/sin a1) (java.lang.Math/sin b1))]
  (* (java.lang.Math/acos (+ x y z)) 6366000)))

(defn meters-to-kilometers 
  "Converts meters to kilometers"
  [m]
  (/ m 1000))

(defn kilometers-to-miles 
  "Converts kilometers to miles"
  [km]
  (* km 0.621371))
