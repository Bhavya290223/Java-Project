# *What To Watch Now*

## The Best Entertainment Recommendation Site

Trying to have a break? but couldn't find the best TV serial or movie to watch? Look no further! 'Cause ***What to Watch Now*** has all the solutions you ever need.

With its *smart and intelligent algorithm*, you can find the best show in just a few clicks and recommend to our whole audience. From latest to old, from spine-tingling to rib-tickling,
from romance to never-ending dramas, it has every genre that you can name.
With its **simple interface**, movie-lovers and serial watchers can save some time searching for a great watch in the internet.

This project interests me because with the onset of new generation and technologies, entertainment content has diversified and countless
things to watch has emerged. Many people including me often faces a dilemma to find the best watch 
but instead end up droomscrolling. So, to save some time off from endless searching and give people a sense of relief from negative news and pandemic, I believe such projects should be made

## User Stories

As a user, I want to be able to:

- Choose a genre and get a list
- Choose a year and get a list
- Choose a language and get a list
- Choose a streaming site and get a list
- Access my watchlist 
- Save a movie for watch later 
- Create a playlist 
- Add ratings 
- Delete a content from my playlist  
- Add a content
- save the list I created. 
- load the list I have saved.

## Phase 4: Task 2

A sample of the event log generated is:

- Tue Nov 23 21:51:16 PST 2021 Added abc to LOC
- Tue Nov 23 21:52:44 PST 2021 Saved MyList
- Tue Nov 23 21:53:07 PST 2021 Loaded MyList

## Phase 4: Task 3

I would have done the following additions:

- Used HashSet to store list of Contents as it is fast and handles duplication
- Used more exceptions to increase robustness and bounds
- Avoided duplication in classes in gui package, by creating a superclass
- displayOptions() method in WhatToWatchNowGUI has generate methods that have a lot of similarities, that could be avoided by calling a generic helper method in all others