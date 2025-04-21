# Description
While we discussed the Gauss Algorithm in our Math class, I realized that this Algorithm is very simple and would be easy to implement in a Language like Java.  
I thought it would be the perfect Project to learn about algorithmic programming, as well as Code structuring.

# What it does
As mentioned previously, this Program uses the concept of the [Gaussian elimination Algorithm](https://en.wikipedia.org/wiki/Gaussian_elimination) to solve any System of Equations.  
I haven't implemented the exact Algorithm, but rather a modified Version of it. This also means that my implementation could be optimized.  
The Algorithm is capable of solving nearly any System of Equations in this standard Form:  
| a₁₁·x₁ + a₁₂·x₂ + ... + a₁ₙ·xₙ = b₁ |  
| a₂₁·x₁ + a₂₂·x₂ + ... + a₂ₙ·xₙ = b₂ |  
.  
.  
.  
| aₙ₁·x₁ + aₙ₂·x₂ + ... + aₙₙ·xₙ = bₙ |

# How it works
The Program consists of two main Parts:
1. IOHandler.java, responsible for handling everything related to Input and Output
2. Gauss.java, this is the File where the Algorithm is programmed

The Code is written in such a way that the Code in IOHandler.java could be replaced with any other Screen handler, as long as the given Functions are kept.  
The Program in its current Form runs in the Terminal.

On startup, the Program will first ask you to name the number of Variables and to give each variable a name.  
Then it will prompt you for each Coefficient of each Variable in each Row, as well as every Constant in each Row.  
Then it will prompt you to check your Input and proceed with printing out a "step-by-step" solving History, as well as the Solutions.

# Limitations of the Program
The Program may encounter some Difficulties if the Coefficients of certain Variables are 0.  
The Program sometimes only gives an approximation for a Solution; this is because it uses doubles to store the Numbers.  
The Numbers get rounded when printed out, but only if they exceed a limit of 10+ digits after the decimal point.  
So it could happen that the Answer the Program gives will be 2.000000001 instead of 2.
