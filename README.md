# Cracking the Android Technical Challenge
## Template project
We often hear from companies that their technical challenge "wouldn't require more than 1 day". Now it really would be so. With this Cracking the android technical challenge repository you could save time on boring modulurasing and initializing all nessessary dependencies and go strait to the business logic and ui.

This template challenge covers 90% of technical challenges base module setup based on my experience. Actually, the level of abstraction is more suitable for big projects. It did so to demonstrate the skills of creating complex architecture. And it could also be used to start with home projects. It includes all that is needed to start creating REST application. 
This project was done by simplyfing my another project wich was done as a technical challenge [Android Feature Module Architecture](https://github.com/IstrajI/android-feature-module-architecture). Check it for more examples of use.

### Detailed tech stack
* Kotlin
* MVVM
* LiveData
* ViewModel
* Dagger2
* Navigation Components
* Retrofit2
* Single Activity Architecture
* Feature Architecture
* Multimodule architecture
* Cooroutines
* Custom Fonts
* Light/Dark theme

### How to use it
Just revert last commit, start creating your own modules from renaming the existing ones. It's better to start in that direction, case modules of the upper layer deppends on modules of the down layer. Core -> Datasource -> Domain -> UI-Components -> Features -> App.
Commit files of each module independently. Don't forget to change time and authority by git ammend. Also take this guide on [more complex operations on git history](http://git-scm.com/book/en/v2/Git-Tools-Rewriting-History). Make this project look as your own and save time for more usefull things!

This template is open for use to everyone. But I must warn, it also could be improved with better abstraction between layers. More over feature navigation is better to replace with custom one if your project would contain deeplinks. Use it if you like, but no warranty. 
