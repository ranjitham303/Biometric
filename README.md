####Biometrics CSCI 860
####Programming Assingment
######Written in Java
============================


**Dataset:** The data consist of keystroke-timing information from 51 subjects (typists), each typing a password (.tie5Roanl) 400 times. (http://www.cs.cmu.edu/~keystroke/)

**Verification Task:** For each user, (**a**) compute the template using mean key hold and key interval features calculated on the first N typing samples; (**b**) compute the genuine and impostor scores using Manhattan distance; and (**c**) calculate and report false accept (impostor pass) and false reject rates at a given threshold T.

**Program Input:** (1) N is the number of samples to be used for building the template (e.g., if N = 200, use the first 200 samples of each user to compute the average vector and the remaining 200 for testing; if N = 100, use the first 100 samples for the template and the remaining 300 for testing); and (2) T is the verification threshold.

**Program Output:** Clearly display false accept (impostor pass) and false reject rates at a given threshold T.

**Deliverables:**
  1. Well documented, compilable software codes and executables performing template calculation; genuine and impostor score computation with Manhattan distance; and calculation of false accept and false reject rates at a given threshold T. [40 points]
  2. A well-written report containing false accept and false reject rates for N = 200 and various threshold values (choose five threshold values that give you the best tradeoff between the false accept and false reject rates). [40 points]
  3. Report the false accept rate at 0 false reject rate, when N = 100, 200, and 300 [20 points]

-----------------------------------------------------------------
**Instructions to run program:**

Compile the java files in console:

`javac Biometric.java Calculate.java CollectData.java`

To run the program, in the console run:

`java Biometric`


Once the program is running, follow the prompts to view results.

The program is designed to show data for one user at a time.

At the first prompt enter `KH` or `INT` to calculate and display Key Hold or Interval FAR (False Accept Rate) and FRR (False Reject Rate) values for a selected user. N value, user number, and a threshold must also be entered when prompted.

At the first prompt enter `OTHER` to get options for displaying genuine or imposter scores. When prompted, enter the desired user number and N value. To return to the first prompt, enter `5` for the return option.

To exit the program, enter `EXIT` at the first prompt screen.
