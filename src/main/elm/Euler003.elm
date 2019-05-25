module Euler003 exposing (euler003)

import Arithmetic


euler003 : String
euler003 =
    Arithmetic.primeFactors 13195
        |> List.maximum
        |> Maybe.withDefault 0
        |> toString
