clear all
clc
close all

%fig 1
x = 0:0.5:3;
subplot(1,2,1)
hold on
plot(x,x.^2,'k.-')
plot(x,sqrt(x),'r^-')
plot(x,log(x),'b*-')
axis tight
grid on
legend('x^2','sqrt(x)','log(x)',...
    'location','NorthWest')
title('Function of x');
xlabel('x')

%continuation
x = 3:0.5:6;0
subplot(1,2,2)
hold on
plot(x,sqrt(x),'r^-')
plot(x,log(x),'b*-')
axis tight
grid on
axis([3 6 -1 9])
title('- continuation');
xlabel('x')