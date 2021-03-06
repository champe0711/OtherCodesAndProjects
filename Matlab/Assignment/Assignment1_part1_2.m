clear all
clc
close all

%Part 1-2 Assignment_1

x1 = [-5 -2 -3 -1 0 0];
x2 = [ 5  2  3  1 0 0];

y1 = [0  1  3  2  5 0];
y2 = [0 -1 -3 -2 -5 0];

%upper left
fill(x1,y1,'k','edgecolor','k',...
'linewidth',1);
hold on
%upper right
fill(x2,y1,[rand,rand,rand],'edgecolor','k',...
'linewidth',1);
hold on

%lower right
fill(x2,y2,'w','edgecolor','k',...
'linewidth',1);
hold on
%lower left
fill(x1,y2,[rand,rand,rand],'edgecolor','k',...
'linewidth',1);
hold on
axis off