(ns cljorbits.systems.solar.saturn)

(defn make-position
  ([app sys]
   (make-position app sys 1))
  ([app sys year]
   "at earth's vernal equinox, in km units, rect cooooord, of course"
   (vec [0 48e7 0])))