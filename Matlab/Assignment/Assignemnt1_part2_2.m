clear all
clc
close all

%Assignment part 2 - 2
x = rand(1,200);
y = rand(1,200);

for i = 1:200
    if(x(i) > y(i))
        %blue triangles
        plot(x(i),y(i),'^',...
            'markersize', 10,...
            'markeredgecolor','b');
        hold on
    elseif( y(1,i) > x(1,i))
        %red stars
        plot(x(i),y(i),'*',...
            'markersize', 10,...
            'markeredgecolor','r');
        hold on
    end
end

axis([0 1 0 1]);
title('Scatterplot');