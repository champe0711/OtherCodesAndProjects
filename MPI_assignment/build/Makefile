BIN=test
LIB=libImplicitSurface.a
OBJECTS= ImplicitSurface.o test.o

CXXFLAGS+=-I../include -O3 -Wall
LDFLAGS+=-L. -lImplicitSurface


all: $(BIN)


$(BIN): $(LIB) test.o
	@echo Build $@
	@$(CXX) -o $@ test.o $(LDFLAGS)


$(LIB): ImplicitSurface.o
	@echo Build $@ from $<
	@$(AR) rcs $@ $<


# Default rule for creating OBJECT files from CXX files
%.o: ../src/%.cxx
	@echo Build $@ from $<
	@$(CXX) $(CXXFLAGS) -c $< -o $@


doc: ../include/ImplicitSurface.h
	doxygen ../doc/Doxyfile


ImplicitSurface.o: ../include/ImplicitSurface.h ../include/ImplicitSurface.inl ../src/ImplicitSurface.cxx
test.o: ../include/ImplicitSurface.h $(LIB) ../src/test.cxx


clean:
	$(RM) $(OBJECTS)
	$(RM) $(LIB)
	$(RM) $(BIN)
	$(RM) -r ../doc/html
	$(RM) -r ../doc/tex

