clear all
clc
close all

% First attemp on MATLAB
% a = eye(4);
% b_a = [1 2 3 4; 5 6 7 8; 9 10 11 12; 13 14 15 16];
% b_b = b_a + 3.5
% c = a + b_b;
% imagesc(c)

% Q7

% Q8
DisplayMode = input('Please input an integer from 1 to 4 -->');
switch DisplayMode
    case 1, disp('One')
    case 2, disp('Two')
    case 3, disp('Three')
    case 4, disp('Four')
    otherwise
        disp('ERROR: Character Input is not 1 or 2 or 3 or 4')
end
