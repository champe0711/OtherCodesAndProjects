clear all
clc
close all

%fig 2 - continuation
x = rand(200,1);
subplot(1,2,1)
hold on
plot(x,sqrt(x),'r^-')
axis tight
grid on
legend('x^2','sqrt(x)','log(x)',...
    'location','NorthWest')
title('- continued');
xlabel('x')
