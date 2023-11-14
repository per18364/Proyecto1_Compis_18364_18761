.data
age: .word 0
hair: .word 0
a: .word 0
b: .word 0
c: .word 0
beso: .byte 0
eyes: .word 0

.text
.global main

getEyes: 
   return - - 69
   jr $ra
lw $t1 age
lw $t2 name
lw $t3 hair
li $t4 5
sw $t4 age
li $t5 a
li $t6 b
li $t7 c
add $t8 a b
add $t9 t8 c
lw $t10 humano
new Human - -
li $t11 newHuman
sw $t11 humano
PARAM age  t12
PUSHPARAM t12
jal in_int 
bark: 
   slt $t13 age 10
   blez $t13 L2
   lw $t14 beso
   add $t15 age 30
   li $t16 t15
   sw $t16 age
   return - - 0
   L2: 
   return - - 1
   L1: 
   jr $ra
main: 
   lw $t17 eyes
   jal getEyes
   li $t19 t18
   sw $t19 eyes
   PARAM eyes  t20
   PUSHPARAM t20
   jal out_int 
   li $v0 10
   syscall 
