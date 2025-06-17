# geo-clj

Wrapper for calling Google Geocode API. Pass in street level address or point of interest, get back latitude and longitude. Calculations use latitude and longitude for deriving distance between two points. 

### Usage

### geocode an address:
(geo-clj.google/geocode "123 main street Fairhaven MA 02719")

### geocode a point of interest:
(geo-clj.google/geocode "Fairhaven Highschool, Fairhaven MA, 02719")

### calculate distance between two distances:
(geo-clj.distance/simple {:lat 41.0 :lng -70} {:lat 41.1 :lng -70.2})

## License

The MIT License (MIT)

Copyright (c) 2025 Matt Bowcock
