# ProblemSolving #
Making right use of data structures and algorithms.
The assignments from "Data structures and algorithms" specialization course from University of San Diego are under
the UCSC folder. Make sure of understanding assignments and then implementing it with your own code. Cheers!

Important techniques: </br>
1.) Dynamic Programming: For problems that have overlapping subproblems, eg: the fibonacci(n) using naive recursion has time
                         complexity of O(2^n). We can either use an iterative approach to bring down complexity or use dynamic 
                         programming. The main gist is to save the solutions of overlapping problems in a data structure and avoid 
                         redundant work.
                         This technique can only be applied if the problem in hand has the property of "OPTIMAL SUBSTRUCTURE".
                         A problem will be of this nature, if it's optimal solution can be found by combining optimal solutions of
                         it's subproblems of the same type. eg: Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)
                         These problems can be of 2 types, i.e. there can be many solutions present for a given problem and we need
                         to get the optimal one. In case of fibonacci, though it has the property of optimal substructure, but at 
                         each recursive call, there is only one solution that comes out. 
                         But there can be problems with optimal substructure property but many solutions possible. For this we pass  
                         arguments to Max or Min.
                         Always prove the optimal substructure property using contradiction or induction.
                         Also for problems that do not have this property, just one example will suffice to prove that dynamic
                         programming can't be applied.
1.)  Greedy algorithms: As the name suggests, these algorithms are greedy at each step and try to get the best at each step.
                        So they always make locally optimal decision. This may not always lead to the correct solution.
                        Eg: Largest number formed from '3', '7', '8', '5'  => will be 8753.  With greedy technique, at each 
                        stage it finds the largest i.e. 8, then 7, then 5, then 3.
                        It is also important to remember the concept of "SAFE MOVE". Not any greedy choice can lead to a right 
                        solution. So the first greedy choice that we make should be safe. This can be done by comparing with an 
                        already existing optimal solution and see if that solution also has the first choice same as our greedy
                        choice. Then we get subproblems and we continue with our greedy choice.
                        "All safe moves are greedy, but not all greedy moves are safe".
