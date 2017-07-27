clear all
clc
close all

%assignment 1 part 2 - 3


for x = 1:20
    y = 1:20;
    z = x;
    
    r = rand; g = rand; b = rand;
    
    %plot horizontal lines
    plot([x,y],z,'s--',...
        'MarkerEdgeColor',[r,g,b],...
        'MarkerFaceColor',[r,g,b],...
        'MarkerSize',20)
    hold on
    axis off
    %plot vertical lines
    plot(x,y,'s--',...
        'MarkerEdgeColor',[r,g,b],...
        'MarkerFaceColor',[r,g,b],...
        'MarkerSize',20)
    hold on
    
    
end

