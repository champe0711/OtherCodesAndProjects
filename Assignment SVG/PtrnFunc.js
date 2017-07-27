var NS = "http://www.w3.org/2000/svg";
var xrf = "http://www.w3.org/1999/xlink";

function createSVGPattern(){
	//get where svg will be displayed
	var body = document.getElementById("displaySVG");
	
	//get all attributes of the js form to create svg
	var noOfShapes = document.getElementById("noOfShapes").value;
	var rows = document.getElementById("rows").value;
	var cols = document.getElementById("cols").value;
	var s1Colour = document.getElementById("s1Colour").value;
	var s2Colour = document.getElementById("s2Colour").value;
	var s3Colour = document.getElementById("s3Colour").value;
	var s4Colour = document.getElementById("s4Colour").value;

	if(rows == "" || cols == ""){
		alert("please put some number to rows and column textbox");
		window.location.reload();
		return;
	}

	// alert("no of Shapes Selected " + noOfShapes +  "\n" +
	// 	   "no of rows inputted " + rows + "\n" +
	// 	   "no of cols inputted " + cols + "\n" +
	// 	   "colour for shape 1 " + s1Colour + "\n" +
	// 	   "colour for shape 2 " + s2Colour + "\n" +
	// 	   "colour for shape 3 " + s3Colour + "\n" + 
	// 	   "colour for shape 4 " + s4Colour);

	//def objects
	var defs = document.createElementNS(NS,"defs");

	var circle = doCircle(20,28,12 , "_c", s1Colour);
	var triangle = doTri(s2Colour ,"_t");
	var rectangle = doRect(40,40, "_r", s3Colour);
	var triangle2 = doTri2(s4Colour,"_tr");

	defs.appendChild(circle);
	defs.appendChild(triangle);
	defs.appendChild(rectangle);
	defs.appendChild(triangle2);


	//for each cases of shape
	var ax = 0, ay=0; // will be used for offset
	var g_ptrn = document.createElementNS(NS,"g");
	g_ptrn.setAttributeNS(null,"id","_ptrn");

	if(noOfShapes == 1){
		var c = useIt("#_c",0, 0);
		g_ptrn.appendChild(c);
		ax=24;
		ay=24;
		// body.appendChild(c)
	} else if ( noOfShapes == 2){
		var c = useIt("#_c",10, 10);
		var t = useIt("#_t",10, 10);

		g_ptrn.appendChild(t);
		g_ptrn.appendChild(c)
		ax = 40;
		ay = 40;
		// body.appendChild(t);
		// body.appendChild(c);
	} else if ( noOfShapes == 3){
		var c = useIt("#_c",10, 10);
		var t = useIt("#_t",10, 10);
		var r = useIt("#_r",10, 10);

		g_ptrn.appendChild(r);
		g_ptrn.appendChild(t);
		g_ptrn.appendChild(c);

		ax = 40;
		ay = 40;
		// body.appendChild(r);
		// body.appendChild(t);
		// body.appendChild(c);
	} else if (noOfShapes == 4) {
		var c = useIt("#_c",10, 40);
		var t = useIt("#_t",10, 40);
		var r = useIt("#_r",10, 40);
		var tr = useIt("#_tr" ,10 , 0);

		g_ptrn.appendChild(r);
		g_ptrn.appendChild(t);
		g_ptrn.appendChild(c);
		g_ptrn.appendChild(tr);

		ax = 40;
		ay = 70;
		// body.appendChild(r);
		// body.appendChild(t);
		// body.appendChild(c);
		// body.appendChild(tr);
	} else if (noOfShapes == 5){
		var g_crt = document.createElementNS(NS,"g");
		g_crt.setAttributeNS(null,"id", "_crt");

		var c = useIt("#_c",10, 40);
		var t = useIt("#_t",10, 40);
		var r = useIt("#_r",10, 40);
		var tr = useIt("#_tr" ,10 , 0);

		g_crt.appendChild(r);
		g_crt.appendChild(t);
		g_crt.appendChild(c);
		g_crt.appendChild(tr);

		var crt2 = useIt("#_crt",0,0);
		crt2.setAttributeNS(null,'transform','rotate(180,30,80)');


		g_ptrn.appendChild(g_crt);
		g_ptrn.appendChild(crt2);

		// body.appendChild(g_crt);
		// body.appendChild(crt2);
		ax = 40;
		ay = 110;
	}


	while(body.firstChild){
		body.removeChild(body.firstChild)
	}

	body.appendChild(defs);	
	body.appendChild(g_ptrn);

	for(var i = 0; i < rows; i++){
		for(var j = 0; j < cols; j++){
			if(i%2 == 1 && noOfShapes == 5){
				body.appendChild(useIt("#_ptrn",ax*j-20,ay*i));
			}else{
				body.appendChild(useIt("#_ptrn",ax*j,ay*i));
			}
		}
	}
}


function doCircle(cx, cy, r, myID, colour){
	var c = document.createElementNS(NS,"circle");
	c.setAttributeNS(null,"id",myID)
	c.setAttributeNS(null,"cx",cx);
	c.setAttributeNS(null,"cy",cy);
	c.setAttributeNS(null,"r",r)
	c.style.fill=colour;
	c.style.opacity=1;
	return c;
}

function doRect(h,w, myID,colour){
	var r = document.createElementNS(NS,"rect");
	r.setAttributeNS(null,"id",myID);
	r.setAttributeNS(null,"height",h);
	r.setAttributeNS(null,"width",w);
	r.style.fill=colour
	r.style.opacity=1;

	return r;
}

function doTri(colour,myID){
	var t = document.createElementNS(NS,"polygon");	
	t.setAttributeNS(null,"id",myID);
	var mypoints = [0,40, 40,40, 20,0];
	t.setAttributeNS(null,"points", mypoints );
	t.style.fill=colour;
	t.style.opacity=1;
	t.style.width=1;

	return t;
}

function doTri2(colour,myID){
	var t2 = document.createElementNS(NS,"polygon");	
	t2.setAttributeNS(null,"id",myID);
	var mypoints = [0,40, 40,40, 20,10];
	t2.setAttributeNS(null,"points", mypoints );
	t2.style.fill=colour;
	t2.style.opacity=1;
	t2.style.width=1;

	return t2;
}

function useIt(shape, x, y){
	var use = document.createElementNS(NS,"use");

	use.setAttributeNS(null,"x",x);
	use.setAttributeNS(null,"y",y);
	use.setAttributeNS(xrf,"href",shape);
	return use;
}
