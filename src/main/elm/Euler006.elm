module Euler006 exposing (euler006)

import List exposing (range, map, sum)


euler006 : String
euler006 =
    diffSumOfSquare 100 |> toString


diffSumOfSquare : Int -> Int
diffSumOfSquare n =
    let
        sumOfSquares =
            range 1 >> map (\x -> x * x) >> sum

        squareOfSums =
            range 1 >> sum >> (\x -> x * x)
    in
        squareOfSums n - sumOfSquares n
