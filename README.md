# README #

This README describes what cse116/504 students will need to do to create their course project on Bitbucket and then bring it into their Eclipse workspace.

### First steps for every team member ###
1. Each member of the team should sign up for a Bitbucket account. If you do not yet have an account, you can create one at: https://bitbucket.org/account/signup/  
2. Creating this account is a two-step process. After the first step, you must check your e-mail and verify the address. Once this is done, you will be ready for the second part of this process.

### Second step for just team member whose last name comes last alphabetically ###
1. Go to bitbucket.org and log in to your account.
2. After you've logged in, click on the `Repositories` item at the top of the webpage.
3. Click on the `Import repository` option in that drop down menu.
4. Copy-and-paste the following text: `https://ProfMatthewHz@bitbucket.org/ProfMatthewHz/cse116f16.git` into the area labeled URL.
5. (For the moment) Make certain that the box labeled `This is a private repository` is **NOT** selected.
6. Click the blue `Import Repository` button.
7. If this worked, you should be on a page labeled *`Overview`* with these steps in the *`Readme`* area.
**DO NOT CLOSE THIS WINDOW. YOUR TEAM WILL NEED THE URL IN THE BOX LABELED `HTTPS` NEAR THE TOP LEFT CORNER**

### Final steps for every team member ###
1. From within Eclipse, select the `Window` menu, choose its `Perspective` and then `Open Perspective` submenus, and finally select the `Other` menu item.
2. In the dialog that opens up, select the list item `Git` and then press the `OK` button.

*We now follow the* [instructions starting at step 8 here](http://crunchify.com/how-to-configure-bitbucket-git-repository-in-you-eclipse/).

3. Either click on the `Clone Git Repository` button (shown on the above webpage) or click on the link labeled `Clone a Git Repository` (the result is the same either way).
4. A dialog box should open. In the area labeled URI, copy the URL shown next to the box labeled `HTTPS` near the top of the page of the imported repository above.
5. Fill in your Bitbucket.org username and password in those areas near the bottom of the dialog.
6. Click the `Next>` button
7. Click the `Next>` button a second time.
8. Near the bottom of the dialog, should be an area labeled `Projects`. Make certain that the box labeled `Import all existing Eclipse projects after clone finishes` **IS SELECTED**.
9. From within Eclipse, select the `Window` menu, choose its `Perspective` and then `Open Perspective` submenus, and finally select the `Other` menu item.
10. In the dialog that opens up, select the list item `Java` and then press the `OK` button.
11. You should now see a new Java project named `CourseProject`. Once everyone in your team can see this, your team is ready for 21st century team-based software development.