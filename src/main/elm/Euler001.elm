module Euler001 exposing (euler001)


euler001 : String
euler001 =
    List.range 1 999
        |> List.filter (\x -> x % 3 == 0 || x % 5 == 0)
        |> List.sum
        |> toString
