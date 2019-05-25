module Euler002 exposing (euler002)

import List.Extra


euler002 : String
euler002 =
    ( 1, 2 )
        |> List.Extra.iterate
            (\( n1, n2 ) ->
                if n1 > 4000000 then
                    Nothing
                else
                    Just ( n2, n1 + n2 )
            )
        |> List.map Tuple.first
        |> List.filter (\n -> n % 2 == 0)
        |> List.sum
        |> toString
