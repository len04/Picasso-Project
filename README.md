# Picasso

An application that allows the user to create expressions that
evaluate to colors and then eventually to images.

The given code base is a good start, but it is sparsely documented
(document each method/part after you understand what it's doing) and,
as your application grows, you may need to refactor.

See the specification for Picasso on the course web site.

## Project Organization

`src` - the source code for the project

`conf` - the configuration files for the project

The `images` directory contains some sample images generated from Picasso.  Some of the expressions for these images can be found in the `expressions` directory.

## Code Base History

This code base originated as a project in a course at Duke University.  The professors realized that the code could be designed better and refactored.  This code base has some code leftover from the original version.

## Group Members

Fekry, Matt, Ngoc, and Petra

## How to Use Extensions

##### 1. Displaying Variables
This extension allows the user to display saved variables on the right side of their screen after assignment. To do this, you simply assign a variable to a value, expression, or an image in the TextBox and press evaluate. 

##### 2. Up & down keystrokes
This extension allows the user to navigate the variable panel on the right of their screen (after assigning more than one variable) by pressing the up or down key on their keyboard. The image is automatically inputed and displayed for the user. Note: the user has to select the frame on the right of the screen in order for the keystrokes to work (i.e., not the TextBox).

##### 3. Random Expressions
This extensions allows the user to populate the expression field with a randomly generated expression by clicking the "Randomize" button. The expression will consist of a random number (within certain limits) of trigonometric functions as well as some custom functions like Wrap and Clamp, and operators such as "+", "-", "*", etc., connecting the functions. It will also randomly select x and y within the expression. The ordering of functions and operations is also random.
