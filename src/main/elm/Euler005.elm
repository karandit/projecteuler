module Euler005 exposing (euler005)

import List
import Dict
import Dict.Extra
import Arithmetic


euler005 : String
euler005 =
    List.range 1 20
        |> List.concatMap Arithmetic.primeExponents
        |> Dict.Extra.groupBy Tuple.first
        |> Dict.map (\n exponents -> exponents |> List.map Tuple.second |> List.maximum |> Maybe.withDefault 0)
        |> Dict.foldl (\n maxexp acc -> acc * n ^ maxexp) 1
        |> toString
