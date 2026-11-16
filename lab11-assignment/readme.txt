Lab 11

a) Status of the lab

All three parts are finished.

Part 1 is finished. The authorization server has three users: john (customer), frank (customer and employee), and mary (customer, employee, and manager). Service A exposes product data for customers, employees, and managers; employee contact data for employees and managers by calling Service B; and salary data for managers by calling Service C. The services are in part1-services.zip.

Part 2 is finished. The startup sequence diagram and the placeOrder sequence diagram are in Part-2-diagrams.pdf.

Part 3 is finished. CheckingAccountService and SavingAccountService support creating an account, depositing, and withdrawing. A withdrawal that would make the balance negative is rejected. TransferClient moves money from a checking account to a saving account as one transaction. If the saving deposit fails, the checking withdrawal is undone and both balances stay the same. That failure is triggered with simulateFailure set to true. The services are in part3-services.zip.

b) Declaration

I hereby declare that this submission is my own original work and to the best of my knowledge it contains no materials previously published or written by another person. I am aware that submitting solutions that are not my own work will result in an NC of the course.

I am aware that I am not allowed to share solutions with other students.

I am aware that if I submit only parts of this lab that points will be subtracted.

I am aware that if my lab submission does not contain this readme.txt file that I do not get points for this lab.

Kshitij Gurung