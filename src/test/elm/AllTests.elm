module AllTests exposing (..)

import Euler001 exposing (..)
import Euler002 exposing (..)
import Euler004 exposing (..)
import Euler005 exposing (..)
import Euler006 exposing (..)
import Euler008 exposing (..)
import Euler009 exposing (..)
import Test exposing (Test, describe, test)


-- import Test.Runner.Html exposing (..)
--         "lynn/elm-arithmetic": "2.0.2 <= v < 2.1.0"
-- /* "elm-community/html-test-runner": "1.0.7 <= v < 2.0.0", */

import Euler003 exposing (..)


-- import Euler010 exposing (..)

import Expect


suite : Test
suite =
    describe "Project Euler"
        [ shouldBe "001" euler001 "233168"
        , shouldBe "002" euler002 "4613732"
        , shouldBe "003" euler003 "29"
          --"6857"
        , shouldBe "004" euler004 "906609"
        , shouldBe "005" euler005 "232792560"
        , shouldBe "006" euler006 "25164150"
          --- "007" "104743"
        , shouldBe "008" euler008 "23514624000"
        , shouldBe "009" euler009 "31875000"
          -- , shouldBe "010" euler010 "142913828922"
        ]


shouldBe : String -> String -> String -> Test
shouldBe id act exp =
    test ("solution " ++ id) <| \() -> Expect.equal exp act
