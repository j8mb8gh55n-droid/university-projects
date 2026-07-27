.model small
.stack 100h
.data

MENULINE  db 0ah,0dh,0ah,0dh,"----------------main menu---------------$"
PRINTMENU db 0ah,0dh,"1.Doctor information",0ah,0dh,"2.book appointment",0ah,0dh,"3.your total",0ah,0dh,"4.quit",0ah,0dh,">> $"
DOCTORS  db 0ah,0dh,0ah,0dh,"DOCTOR NAME | LOCATION | WORKING HOURS ",0ah,0dh, "DR.Anna | Exit 7,Riydah St. | 1-3pm ",0ah,0dh,"DR.Velma | Exit 8,Dammam St. | 9-11am ", 0ah,0dh,"DR.Suzi | Exit 9,Jeddah St. | 10-12pm $"
APPOINTMENTS db 0ah,0dh,0ah,0dh,"----------------APPOINTMENTS AND PRICES----------------",0ah,0dh,"|APPOINTMENT NUMBER | DOCTOR NAME | TIME | PRICE|",0ah,0dh,"|1 | DR.Anna | 1-2pm | 200sar|",0ah,0dh,"|2 | DR.Anna | 2-3pm | 200sar|", 0ah,0dh,"|3 | DR.Velma | 9-10am | 350sar|", 0ah,0dh,"|4 | DR.Velma | 10-11am | 350sar|", 0ah,0dh,"|5 | DR.Suzi | 10-11am | 500sar|", 0ah,0dh,"|6 | DR.Suzi | 11-12pm | 500sar|", 0ah,0dh,">> $"
PRICE dw 0
ANNA db 0ah,0dh,0ah,0dh,"you have successfully booked with DR.Anna $" 
VELMA db 0ah,0dh,0ah,0dh,"you have successfully booked with DR.Velma $"
SUZI db 0ah,0dh,0ah,0dh,"you have successfully booked with DR.Suzi $"
TOTAL db 0ah,0dh,0dh,0dh,"your total is: $" 
d40 dw 40
DISCOUNT dw 0 
TOTALDISCOUNT db 0ah,0dh,0dh,0dh,"your total after 40% discount is: $"
DISCOUNTEDPRICE dw 0
dtotal dw 0
STUDENTDISCOUNT db 0ah,0dh,0ah,0dh,"are you a student?",0ah,0dh,"1.yes",0ah,0dh,"2.no",0ah,0dh,">>$"
GOODBYEMSG db "---GOODBYE-- $" 
EXCEPTION db 0ah,0dh,"wrong choice: enter valid option $"

.code          
main proc

mov ax,@data
mov ds,ax

MENU:           
mov ah,9        ;display the main menu
lea dx,MENULINE
int 21h

mov ah,9        ;display the main menu
lea dx,PRINTMENU
int 21h  

mov ah,1        ;take input from user
int 21h
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 


CMP AL,31H    ;CHECK IF THE USER INPUT NUMBER "1"
JE  OPTION1       ;JUMP TO FIRST OPTION             "je conditional jump"   

CMP AL,32h    ;CHECK IF THE USER INPUT NUMBER "2"
JE OPTION2        ;JUMP TO SECOND OPTION  

CMP AL,33h    ;CHECK IF THE USER INPUT NUMBER "3"
JE OPTION3        ;JUMP TO THIRD OPTION 

CMP AL,34h    ;CHECK IF THE USER INPUT NUMBER "4"
JE OPTION4        ;JUMP TO FOURTH OPTION  

mov ah,9
lea dx,EXCEPTION ;WRONG INPUT DISPLAY ERROR MESSAGE
int 21h
jmp MENU
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

OPTION1:      ;display all the names of the doctors and their information
mov ah,9
lea dx,DOCTORS
int 21h
JMP MENU      ;go back to main menu 




OPTION2:      ;booking an appointment
mov ah,9      ;display appointments menu
lea dx,APPOINTMENTS
int 21h 

mov ah,1      ;take input from user
int 21h

;{
  ;CHECK THE USER INPUT  1-6  "je conditional jump"
  cmp al,31h
  je APT1
  cmp al,32h
  je APT2
  cmp al,33h
  je APT3
  cmp al,34h
  je APT4
  cmp al,35h
  je APT5
  cmp al,36h
  je APT6
  mov ah,9 
  
  lea dx,EXCEPTION ;WRONG INPUT DISPLAY ERROR MESSAGE
  int 21h 
  jmp OPTION2
  
 ;{
  APT1:
    mov PRICE,200 ;give price the value 200
    mov ah,9      ;display booking proccess going through message
    lea dx,ANNA
    int 21h
    jmp MENU       ;go back to main menu 
    
  APT2:
    mov PRICE,200 ;give price the value 200
    mov ah,9      ;display booking proccess going through message
    lea dx,ANNA
    int 21h
    jmp MENU       ;go back to main menu
    
  APT3:
    mov PRICE,350 ;give price the value 350
    mov ah,9      ;display booking proccess going through message
    lea dx,VELMA
    int 21h
    jmp MENU       ;go back to main menu 
    
  APT4:
    mov PRICE,350 ;give price the value 350
    mov ah,9      ;display booking proccess going through message
    lea dx,VELMA   
    int 21h
    jmp MENU       ;go back to main menu 
    
  APT5:
    mov PRICE,500 ;give price the value 500
    mov ah,9      ;display booking proccess going through message
    lea dx,SUZI 
    int 21h
    jmp MENU       ;go back to main menu 
    
  APT6:
    mov PRICE,500 ;give price the value 500
    mov ah,9      ;display booking proccess going through message
    lea dx,SUZI
    int 21h
    jmp MENU       ;go back to main menu  
 ;} 
 
;}
JMP MENU     ;go back to main menu

OPTION3:
 
 mov ah,9       ;ask the user if they are a student
 lea dx,STUDENTDISCOUNT
 int 21h
 
 mov ah,1       ;take input from user
 int 21h
 
;{  
    cmp al,31h
    je  STUDENT
    cmp al,32h
    je  NOTSTUDENT
    mov ah,9
    lea dx,EXCEPTION ;WRONG INPUT DISPLAY ERROR MESSAGE
    int 21h
    jmp OPTION3


    ;{
    NOTSTUDENT:
     mov ah,9    ;display total message
     lea dx,TOTAL
     int 21h
 
     mov ax,PRICE   ;memory location is ax
     call OUTDEC    ;call outdec to display our 3 digit decimal number 
     jmp MENU       ;go back to main menu
    STUDENT:
     mov ah,9       ;display total message
     lea dx,TOTAL
     int 21h
     mov ax,PRICE   ;memory location is ax
     call OUTDEC    ;call outdec to display our 3 digit decimal number
     
     
      
      
     mov ax,PRICE
     mov DISCOUNTEDPRICE , ax
     mul d40
     mov bx,100
     div bx
     
     sub DISCOUNTEDPRICE,ax
     
     
     
     mov ah,9       ;display total after discount message
     lea dx,TOTALDISCOUNT
     int 21h 
     
     mov ax,DISCOUNTEDPRICE
     call OUTDEC
     
     
     
      
     jmp MENU       ;go back to main menu
    ;}
;}
     




OPTION4:     ;exit the application
mov ah,9     ;display goodbye message
lea dx,GOODBYEMSG
int 21h 

mov ah,4ch   ;quit
int 21h
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
main endp

; to print multi digit decimal number
OUTDEC	PROC
PUSH	AX
PUSH	BX
PUSH	CX
PUSH	DX
OR	AX,AX
JGE	@END_IF1
PUSH	AX
MOV	DL,'-'
MOV	AH,2
INT	21H
POP	AX
NEG	AX
@END_IF1:
XOR	CX,CX
MOV	BX,10D
@REPEAT1:
XOR	DX,DX
DIV	BX
PUSH	DX
INC	CX
OR	AX,AX
JNE	@REPEAT1
MOV	AH,2
@PRINT_LOOP:
POP	DX
OR	DL,30H
INT	21H
LOOP	@PRINT_LOOP
POP	DX
POP	CX
POP	BX
POP	AX

RET
OUTDEC	ENDP


end main