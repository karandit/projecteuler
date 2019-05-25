module Euler004 exposing (euler004)


euler004 : String
euler004 =
    List.range 100 999
        |> List.concatMap (\n1 -> List.range 100 999 |> List.map (\n2 -> n1 * n2))
        |> List.filter (toString >> (\s -> String.reverse s == s))
        |> List.maximum
        |> Maybe.map toString
        |> Maybe.withDefault "no solution"
