close all
clear all
clc

A = imread('joey2.jpg');
h = imshow(A);

for i = 1:100
    %quadrant 1
    B = A;
    %size(A,1) choose the column that you wanted from the matrix of A
    %round() will change the number to an integer
    %rand will generate a random number and multiply to 3 and ceil will
    %produce the highest number
    B(1:round(size(A,1)/2),1:round(size(A,2)/2),ceil(rand*3)) = 255;
    set(h,'CData',B);
    pause(0.3)
    
    %quadrant 2
    B = A;
    B(round(size(A,1)/2)+1:end,...
        round(end/2)+1:end,...
        ceil(rand*3)...
        ) = 255;
    
    set(h,'CData',B);
    pause(0.3)
    
    %quadrant 3
    B = A;
    B(round(end/2)+1:end,round(end/2)+1:end,ceil(rand*3)) = 255;
    set(h,'CData',B);
    pause(0.3)
    
    %quadrant 4
end


%Q1 = A(1:round(size(A,1)/2),1:round(size(A,2)/2),:);



