Title: 3DModelling

In this assignment I have tried my upmost best to achieve the following objectives:

A. Writing eSOS rules and interpreting them

B. Connecting eSOS to the TEXT and JavaFX plugins

C. Inclusion of informalandInternal.txt

D. An External to Internal Translator

E. Atrribute/action interpreter

F. Test Strings for External to Internal Translator and Atrribute/action interpreter

G. A report regarding the project

This assignment has been developed on Un*x so please use the commands as required to the specification of your machine.The instructions are the same ones that are provided to us in other documents. But an overview of instructions to run with a local plugin when accessing from desktop(All the commands are the same as been explained in the labs and lectures. Please refer to them incase of confusion): 
1.Run eSOS with a local plugin(Un*x commands)
> cd Desktop
  cd SLE(Assignment1)
  ../buildPlugin.sh
  ../artfx.sh eSOS_PiM.art
 This will generate a lot of outputs, culminating in along with :
 *** try create_new_object("sphere"), {} with relation  -> 
Step 1
  Rewrite call 1 create_new_object("sphere"), {}  -> 
  -createNewObject  --- create_new_object(_type), _sig -> __user("create_new_object", _type), _sig
The command is unknown create_new_object
  -createNewObject rewrites to "value returned", {}
Step 2
  Rewrite call 2 "value returned", {}  -> 
    Terminal "value returned", {}
Normal termination on "value returned", {} after 2 steps and 2 rewrites
*** try add(22.0, 3.0), {} with relation  -> 
Step 1
  Rewrite call 1 add(22.0, 3.0), {}  -> 
  -add _n1 |> _  _n2 |> _ --- add(_n1, _n2), _sig -> __add(_n1, _n2), _sig
  -add rewrites to 25.0, {}
Step 2
  Rewrite call 2 25.0, {}  -> 
    Terminal 25.0, {}
Normal termination on 25.0, {} after 2 steps and 2 rewrites
*** try backend(1, 2, 3), {} with relation  -> 
Step 1
  Rewrite call 1 backend(1, 2, 3), {}  -> 
  -backend  --- backend(_P1, _P2, _P3), _sig -> __user(_P1, _P2, _P3)
The command is unknown 1
  -backend rewrites to "value returned"
Step 2
  Rewrite call 2 "value returned"  -> 
    Terminal "value returned"
Normal termination on "value returned" after 2 steps and 2 rewrites
*** try multiply(23.6, 0.2), {} with relation  -> 
Step 1
  Rewrite call 1 multiply(23.6, 0.2), {}  -> 
  -multiply _n1 |> _  _n2 |> _ --- multiply(_n1, _n2), _sig -> __mul(_n1, _n2), _sig
  -multiply rewrites to 4.720000000000001, {}
Step 2
  Rewrite call 2 4.720000000000001, {}  -> 
    Terminal 4.720000000000001, {}
Normal termination on 4.720000000000001, {} after 2 steps and 2 rewrites
........(continues to a long message)

2. To run the ExtToInt_PiM.art file
Build a term

>  ..\artV3.sh ExtToInt_PiM +showAll

This will print a term on the console in indented form:

** Accept
1: seq
  2: seq
    3: seq
      4: seq
        5: seq
          6: seq
            7: seq
              8: seq
                9: seq
                  10: seq
                    11: seq
                      12: seq
                        13: seq
                          14: seq
                            15: seq
                              16: seq
                                17: seq
                                  18: seq
                                    19: seq
                                      20: seq
                                        21: seq
                                          22: seq
                                            23: seq
                                              24: seq
                                                25: seq
                                                  26: seq
                                                    27: seq
                                                      28: seq
                                                        29: seq
                                                          30: seq
                                                            31: assign
                                                              32: a
                                                              33: 15


...
      773: exp
        774: deref
        775: i
        776: deref
        777: j
  778: backend
    779: 1
    780: 2
    781: 3

3. To run the Attribute_PiM
Build and run the Java-native attribute grammar

>  ..\artV3.sh Attribute_PiM
** Accept
x is 5
x is 6
x is 7
x is 8
x is 9
x is 10
...

> ..\artV3.sh Attribute_PiM + showAll
1: statements
  2: statement
    3: '{'
    4: statements
      5: statement
        6: ID < rightExtent=4 leftExtent=1 lexeme=x v=x >
          7: x
        8: '='
        9: e0 < v=5 >

        
ORIGINAL STEPS: 
--- IF YOU ARE RUNNING ON Un*x ---

The instructions below are for running the demonstrations on Windows. If you are running on Un*x:

1. Instead of writing, say, ..\art.bat You will need to use commands of the form ../art.sh, and similarly for other batch files.
2. Instead of copy you say cp.
3. Instead of type you say cat.
4. Remember that Un*x is case-sensitive.

--- INSTRUCTIONS FOR RUNNING ---

1. Read the top level README file in SLELabs/00README.txt.

2. Run eSOS without a local plugin

> ..\art eSOS_PiM.art

This will generate a lot of output, culminating in:

...

Step 55
  Rewrite call 233 seq(__done, backend(1, 2, 3)), {gcd=3, b=3, a=3}  ->
  -sequenceDone  --- seq(__done, _C), _sig -> _C, _sig
  -sequenceDone rewrites to backend(1, 2, 3), {gcd=3, b=3, a=3}
Step 56
  Rewrite call 234 backend(1, 2, 3), {gcd=3, b=3, a=3}  ->
  -backend  --- backend(_P1, _P2, _P3), _sig -> __user(_P1, _P2, _P3)
Default ValueUserPlugin called with 3 arguments
__int32(1) which has underlying Java class java.lang.Integer and value: 1
__int32(2) which has underlying Java class java.lang.Integer and value: 2
__int32(3) which has underlying Java class java.lang.Integer and value: 3
  -backend rewrites to "Default"
Step 57
  Rewrite call 235 "Default"  ->
    Terminal "Default"
Normal termination on "Default" after 57 steps and 235 rewrites

3. Copy the example text plugin to ValueUserPlugin.java and compile

>  copy ValueUserPlugin_TEXT.java ValueUserPlugin.java
>  ..\buildPlugin.bat

4. Run eSOS with the compiled text plugin

> ..\art eSOS_PiM.art

The output from the last step now changes to:

...
  -backend rewrites to "Return value from text example plugin"
Step 57
  Rewrite call 235 "Return value from text example plugin"  ->
    Terminal "Return value from text example plugin"
  
5. Copy the example Java FX plugin to VAlueUserPlugin.java and compile

>  copy ValueUserPlugin_FX.java ValueUserPlugin.java
>  ..\buildPlugin.bat

6. Run eSOS with the compiled Java FX plugin using the artfx script. 

> ..\artfx eSOS_PiM.art

...

Step 57
  Rewrite call 235 "Return value from JavaFX example plugin"  ->
    Terminal "Return value from JavaFX example plugin"
Normal termination on "Return value from JavaFX example plugin" after 57 steps and 235 rewrites  

... and in addition, a JavaFX window opens displaying __int32(1) You must close the window to terminate the program.










 
