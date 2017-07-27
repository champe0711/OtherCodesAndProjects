clear all
clc
close all

%(i) array of quantifiers
%(ii) nouns of expression
%(III) verbs
%(iv) another array one with nouns or expressions

i =   {'all ', 'few ', 'many ', 'several ', 'some ', 'every ', 'each ', 'one ', 'none ', 'no one '};
ii =  {'Government ', 'you ', 'I ', 'Thomas ', 'Europe ', 'animals ', 'University ', 'politicians ', 'World ', 'Hazem '};
iii = {'eat ', 'drink ', 'grow ', 'walk ', 'run ', 'jump ', 'sing ', 'hugs ', 'adore ', 'look '};
iv = {'the world', 'ACTA' , 'hogwarts!', 'like a G6', 'and goes mental','like an owl','to music','is alone','arguement is invalid','Lord of the Rings'}; 

theString = [i{ceil(rand*10)}, ii{ceil(rand*10)}, iii{ceil(rand*10)}, iv{ceil(rand*10)}];
disp(theString);