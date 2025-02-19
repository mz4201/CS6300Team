# Team 032 - CS6300 Summer 2024 - Design Discussion

## Design 1 - mzhao341
With no prior design experience, I did my best to map out the system interactions. Although there were many uncertainties, I aimed to include all specified details, like save and cancel features. Compared to my teammates, my structure was less clear, especially in differentiating between Current Job and Job Offer, which wasn't necessary. However, at least the overall layout is clean and easy to read.
![mzhao341 Original Design](../Design-Individual/mzhao341/design.png)

## Design 2 - pwang422

With limited design experience, I did my best to contribute to it. While I aimed to include the necessary features and requirements, my design could benefit from more specificity and detail. Additionally, the UML diagrams are missing a lot of features, and the overall design has a significant flaw that needs to be addressed.
![pwang422 Original Design](../Design-Individual/pwang422/design.png)

## Design 3 - ssinha96
The design document that I made was for an application that would have been extensible and scalable.
However, for the purposes of the group project, which will be written in Android, I don't think my approach would work.

That said, I do think that my generalization of a job, rather than having separate ways of storing a current job and an offered job is elegant.

The design document that I made was for an application that would have been extensible and scalable. However, for the purposes of the group project, which will be written in Android, I don't think my approach would work. That said, I do think that my generalization of a job, rather than having separate ways of storing a current job and an offered job is elegant.

![ssinha96 Original Design](../Design-Individual/ssinha96/design_1.png)
![ssinha96 Original Design](../Design-Individual/ssinha96/design_2.png)

## Design 4 - tsachse3

My original design was somewhat adapted to building an Android app but had some flaws and gaps that needed to be fleshed out. Android has several unique quirks that break some OOP concepts and my design did not account for those quirks. Otherwise my design maps pretty well to the requirements and had an acceptable amount of detail.

![tsachse3 Original Design](../Design-Individual/tsachse3/design.png)

## Team Design

Our proposed design is inspired by a little bit of everyone's individual work. It provides a separate page (Android activity) for each key feature and includes a succinct data model that treats offers and the current job as instances of the same class. It is also adapted to Android specifically by inheriting from Android's `Activity` class and by using `ViewModels` for persistent state storage.

![Activities UML Design](../Docs/Images/activities-uml-diagram.png)

![Data UML Design](../Docs/Images/data-uml-diagram.png)

## Summary

During our discussion we learned that each individual has certain strengths and it's important to play into teammates' strengths. We also explored compromising and synthesizing ideas into a single cohesive plan. We found that key assumptions about the software or the software's environment can change, leading to new challenges that must be solved. This means it's important to balance detail and speed early in the design process to remain flexible and adaptable.
