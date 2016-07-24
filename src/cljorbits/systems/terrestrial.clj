(ns cljorbits.systems.terrestrial)

; http://nssdc.gsfc.nasa.gov/planetary/factsheet/
(def planets
  {:planets-vec
   [
    {:name :mercury :nasa "http://nssdc.gsfc.nasa.gov/planetary/planets/mercurypage.html"
     :rotat-rad 2 :ecc-obl-prec { }
     :orbits-mya
     { 0.0 {:semi-major-axis-km 57.9e6
            :eccentricity 0.205
            :semi-minor-axis-km nil                         ; calculated
            :period-hours (* 88.0 24)
            :inclination-deg 7.0 } }
     }
    {:name :venus
     :rotat-rad 2 :ecc-obl-prec { }
     :orbits-mya
     { 0.0 {:semi-major-axis-km 108.2e6
            :eccentricity 0.205
           :semi-minor-axis-km nil
           :period-hours (* 224.7 24)
           :inclination-deg 3.4 } }
     }
    {:name :earth
     :rotat-rad 2 :ecc-obl-prec { }
     :orbits-mya
     { 0.0 {:semi-major-axis-km 149.6e6
            :eccentricity 0.0
            :semi-minor-axis-km nil
            :period-hours (* 365.25 24)
            :inclination-deg 0 } }
     }

    ; moon - 27.3 days

    {:name :mars
     :rotat-rad 2 :ecc-obl-prec { }
     :orbits-mya
     { 0.0 {:semi-major-axis-km 227.9e6
            :eccentricity 0.0
            :semi-minor-axis-km nil
            :period-hours (* 687.0 24)
            :inclination-deg 1.9 } }
     }
    {:name :jupiter
     :rotat-rad 2 :ecc-obl-prec { }
     :orbits-mya
     { 0.0 {:semi-major-axis-km 778.6e6
            :eccentricity 0.0
            :semi-minor-axis-km nil
            :period-hours (* 4331 24)
            :inclination-deg 1.3 } }
     }
    {:name :saturn
     :rotat-rad 2 :ecc-obl-prec { }
     :orbits-mya
     { 0.0 {:semi-major-axis-km 1433.5e6
            :eccentricity 0.0
            :semi-minor-axis-km nil
            :period-hours (* 10747.0 24)
            :inclination-deg 2.5 } }
     }
    {:name :uranus
     :rotat-rad 2 :ecc-obl-prec { }
     :orbits-mya
     { 0.0 {:semi-major-axis-km 2872.5e6
            :eccentricity 0.0
            :semi-minor-axis-km nil
            :period-hours (* 30589.0 24)
            :inclination-deg 0.8 } }
     }
    {:name :neptune
     :rotat-rad 2 :ecc-obl-prec { }
     :orbits-mya
     { 0.0 {:semi-major-axis-km 4495.1e6
            :eccentricity 0.0
            :semi-minor-axis-km nil
            :period-hours (* 59800.0 24)
            :inclination-deg 1.8 } }
     }
    ]
   })