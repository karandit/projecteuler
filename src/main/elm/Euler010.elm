module Euler010 exposing (euler010)

import Arithmetic


euler010 : String
euler010 =
    Arithmetic.primesBelow 2000000
        |> List.sum
        |> toString
