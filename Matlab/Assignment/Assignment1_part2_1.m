clear all
clc
close all

%Assignment part 2 - 1
x = rand(1,200);
y = (x.*10) - 5;
x = y;

%create plot
plot(x,'k');
axis([0 200 -5 5]);
title('Signal');