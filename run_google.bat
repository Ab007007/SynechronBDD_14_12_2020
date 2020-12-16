echo " Welcome to Batch Executioin  - Project Module"
cd D:\SynechronBDD_14_12_2020\Eclipse_WS\bddTraining
d:
set path=%path%
set classpath=D:\SynechronBDD_14_12_2020\Eclipse_WS\bddTraining\target\*;.
mvn test -Dcucumber.filter.tags="@smoke1 and @regression1"
