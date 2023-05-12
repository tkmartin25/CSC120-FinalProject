# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 My overall approach was drawing a house on paper and then creating rooms through a coordinate system. I then used this coordinate and room system to create the system of moving throughout the house. I then added the ways the user can die through energy loss, through losing to the character at the end of the game, as well as ways the player can help themselves with the potions. 

 - What **new thing(s)** did you learn / figure out in completing this project?
 I realized how important it is to create a detailed plan before starting a project as it quickly gets overwhelming. The other assignments we have done in this class are step by step, but this was very much complete freedom, so it was hard to know how to plan things. If I could do this project again, I would spend much more time asking questions even before I start writing the code. 

 - Is there anything that you wish you had **implemented differently**?
Yes, there are many things I wish I had implemented differently. I kept struggling with calling non-static methods in static ways. If I changed the attribute or method to static, it would mess up the actual method, but if I changed it to calling an instance of the class, it was often not resolved because the instance of the class was created in a different function/file. I ended up having to create rooms multiple times due to this issue, and I think this is an inefficient way to code.

 - If you had **unlimited time**, what additional features would you implement?
I would implement more objects such as food to eat, weapons to use, and other characters, such as witches, bats, and ghosts throughout the house.

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
My friend Anna-Lee described to me how to make it so that the user types in the terminal and the commands execute, rather than the user having to type the actual commands in the main. She told me to open a scanner and use an if else ladder with the commands. 

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 I would advise myself to start working much earlier and to ask a lot of questions before writing the code.

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
N/A