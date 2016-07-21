# cljorbits

FIXME: description

## Installation

Download from http://example.com/FIXME.

## Usage

FIXME: explanation

    $ java -jar cljorbits-0.1.0-standalone.jar [args]

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

Three CCSDS-recommended Orbit Data Messages (ODMs) are described in this
Recommended Standard: the Orbit Parameter Message (OPM), the Orbit Mean-Elements
Message (OMM), and the Orbit Ephemeris Message (OEM). 

http://public.ccsds.org/publications/archive/502x0b2c1.pdf

user=> (def a [1 2 3 4])
#'user/a
user=> (prn-str a)
"[1 2 3 4]\n"
user=> (spit "stored-array.dat" (prn-str a))
nil
(in a new REPL session)

user=> (require 'clojure.edn)
nil
user=> (slurp "stored-array.dat")
"[1 2 3 4]\n"
user=> (clojure.edn/read-string (slurp "stored-array.dat"))
[1 2 3 4]



CCSDS_OPM_VERS = 2.0
CREATION_DATE = 1998-11-06T09:23:57
ORIGINATOR = JAXA
COMMENT GEOCENTRIC, CARTESIAN, EARTH FIXED
OBJECT_NAME = GODZILLA 5
OBJECT_ID = 1998-057A
CENTER_NAME = EARTH
REF_FRAME = ITRF-97
TIME_SYSTEM = UTC
EPOCH = 1998-12-18T14:28:15.1172
X = 6503.514000
Y = 1239.647000
Z = -717.490000
X_DOT = -0.873160
Y_DOT = 8.740420
Z_DOT = -4.191076
MASS = 3000.000000
SOLAR_RAD_AREA = 18.770000
SOLAR_RAD_COEFF = 1.000000
DRAG_AREA = 18.770000
DRAG_COEFF = 2.500000
CX_X = 3.331349476038534e-04
CY_X = 4.618927349220216e-04
CY_Y = 6.782421679971363e-04
CZ_X = -3.070007847730449e-04
CZ_Y = -4.221234189514228e-04
CZ_Z = 3.231931992380369e-04
CX_DOT_X = -3.349365033922630e-07
CX_DOT_Y = -4.686084221046758e-07
CX_DOT_Z = 2.484949578400095e-07
CX_DOT_X_DOT = 4.296022805587290e-10
CY_DOT_X = -2.211832501084875e-07
CY_DOT_Y = -2.864186892102733e-07
CY_DOT_Z = 1.798098699846038e-07
CY_DOT_X_DOT = 2.608899201686016e-10
CY_DOT_Y_DOT = 1.767514756338532e-10
CZ_DOT_X = -3.041346050686871e-07
CZ_DOT_Y = -4.989496988610662e-07
CZ_DOT_Z = 3.540310904497689e-07
CZ_DOT_X_DOT = 1.869263192954590e-10
CZ_DOT_Y_DOT = 1.008862586240695e-10
CZ_DOT_Z_DOT = 6.224444338635500e-10


## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
