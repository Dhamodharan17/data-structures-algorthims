#### Edit Distance

- 3 Operations we can person insert, delete, replace
  - Case 1 : both char match 0 + (p1-1,p2-1) move both
  - Case 2 : does not match
  - Case 2.1 : insert a new character to match both strings = 1 + (p1-1,p2-1)
  - Case 2.2 : update a character in p2 to match both strings = 1+ (p1-1,p2-1)
  - Case 2.3 : delete a character to match both strings 1 + (p1-1,p2) p1 = horse p2 = ros
####

