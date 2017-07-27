clear all
clc
close all


pause

play(auob)
s = size(Ag);
beam_width = 5;
beam = ones(beam_width,s(2),3);
beam(:,:,1) = 255;
for i = 1:beam_width:s(1)
    C = [B(1:i, :,:); beam;...
        A(i + beam_width + 1,end,:,:);
set(h,'CData',C);
pause(0.02)
end

stop(auob)

close all
clear all
clc

A = imread('joey.jpg');

Ag = rgb2gray(A);