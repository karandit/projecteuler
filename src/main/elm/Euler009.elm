module Euler009 exposing (euler009)


euler009 : String
euler009 =
    for ( 1, (>) 1000, (+) 1 )
        (\a ->
            for ( a + 1, (\b -> a + b < 1000), (+) 1 )
                (\b ->
                    if (a ^ 2 + b ^ 2 == (1000 - a - b) ^ 2) then
                        Just <| toString <| a * b * (1000 - a - b)
                    else
                        Nothing
                )
        )
        |> Maybe.withDefault "no solution"


for : ( a, a -> Bool, a -> a ) -> (a -> Maybe b) -> Maybe b
for ( i, cond, next ) body =
    if cond i then
        case body i of
            (Just _) as res ->
                res

            Nothing ->
                for ( next i, cond, next ) body
    else
        Nothing
