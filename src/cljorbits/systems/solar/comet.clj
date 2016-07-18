(ns cljorbits.systems.solar.comet)

; TODO eccentricity
(defn make-position
  ([app sys class-name]
   (make-position app sys class-name 1))
  ([app sys [class name] year]
   "at earth's vernal equinox, in km units, rect cooooord, of course"
   (case class
     :comet (case name
              :shoemaker (vec [0 3e8 0])
              :n1 (vec [0 3.5e7 0])
              (vec [0 4e8 0]))
     :asteroid (case name
                 :x1 (vec [0 4e8 0]))
     (vec [0 1.2e9 0]))
   ))
