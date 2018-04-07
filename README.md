# ProblemSolving #
Making right use of data structures and algorithms.
The assignments from "Data structures and algorithms" specialization course from University of San Diego are under
the UCSC folder. Make sure of understanding assignments and then implementing it with your own code. Cheers!

Important algorithms: </br>
1.)  Greedy algorithms: As the name suggests, these algorithms are greedy at each step and try to get the best at each step.
                        So they always make locally optimal decision. This may not always lead to the correct solution.
                        Eg: Largest number formed from '3', '7', '8', '5'  => will be 8753.  With greedy technique, at each 
                        stage it finds the largest i.e. 8, then 7, then 5, then 3.
                        It is also important to remember the concept of "SAFE MOVE". Not any greedy choice can lead to a right 
                        solution. So the first greedy choice that we make should be safe. This can be done by comparing with an 
                        already existing optimal solution and see if that solution also has the first choice same as our greedy
                        choice. Then we get subproblems and we continue with our greedy choice.
                        "All safe moves are greedy, but not all greedy moves are safe".
