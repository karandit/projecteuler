module Util.Prime exposing (isPrime)

import BigInt as BI exposing (..)


{-|
Prime numbers are divisble by themselves and 1.
Because the constructor for `Prime` is not exported, you can be
confident that if you are using a `Prime`, then its `Prime`.
@docs Prime, fromInt, toInt
-}



-- https://github.com/Fresheyeball/elm-restrict-number/blob/2.2.0/Prime.elm
-- https://github.com/lynn/elm-arithmetic/blob/2.0.2/src/Arithmetic.elm
-- Prime, fromInt, toInt)
-- type Prime
--     = Prime Int
-- fromInt : Int -> Maybe Prime
-- fromInt x =
--     if isPrime x then
--         Just (Prime x)
--     else
--         Nothing
--
--
-- toInt : Prime -> Int
-- toInt (Prime x) =
--     x
--


big0 : BigInt
big0 =
    BI.fromInt 0


big1 : BigInt
big1 =
    BI.fromInt 1


big2 : BigInt
big2 =
    BI.fromInt 2


big3 : BigInt
big3 =
    BI.fromInt 3


big9 : BigInt
big9 =
    BI.fromInt 9


isPrime : BigInt -> Bool
isPrime x =
    if BI.compare x big2 == EQ || BI.compare x big3 == EQ then
        True
    else if BI.compare x big2 == LT || (BI.mod x big2 |> BI.compare big0) == EQ then
        False
    else if BI.compare x big9 == LT then
        True
    else if (BI.mod x big3 |> BI.compare big0) == EQ then
        False
    else
        let
            f n z =
                if BI.compare n z == EQ then
                    True
                else if (BI.mod n z |> BI.compare big0) == EQ then
                    False
                else if BI.compare z n == LT then
                    f n (BI.add z big1)
                else
                    False
        in
            f x big2
