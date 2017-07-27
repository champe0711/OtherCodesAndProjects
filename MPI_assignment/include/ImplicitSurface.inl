/**
********************************************************************************
*
*	@file		ImplicitSurface.inl
*
*	@brief		Functions to build 3D implicit surfaces. To know what implicit
*				surfaces are, please visit Paul Bourke's tutorial available at
*				http://paulbourke.net/geometry/implicitsurf/
*
*	@version	1.0
*
*	@date		08/03/2014
*
*	@author		Dr Franck P. Vidal
*
********************************************************************************
*/


//******************************************************************************
//	Include
//******************************************************************************
#include <cmath>


//-------------------------------------------------------------
inline float evaluate(DensityFunctionType aDensityFunctionType,
					  float r,
					  float a,
					  float b)
//-------------------------------------------------------------
{
	switch (aDensityFunctionType)
	{
	case SPHERE:
		return (evaluateSphere(r));
		
	case BLOBBY_MOLECULE:
		return (evaluateBlobbyMolecule(r, a, b));
		
	case META_BALL:
		return (evaluateMetaBall(r, a, b));
		
	case SOFT_OBJECT:
		return (evaluateSoftObject(r, a, b));

	default:
		return (0);
	}
}


//----------------------------------
inline float evaluateSphere(float r)
//----------------------------------
{
	if (0 <= r)
	{
		return (1.0 / (r * r));		
	}
	else
	{
		return (0);
	}
}


//------------------------------------------------------------
inline float evaluateBlobbyMolecule(float r, float a, float b)
//------------------------------------------------------------
{
	if (0 <= r)
	{
		return (a * exp(-b * r * r));		
	}
	else
	{
		return (0);
	}
}


//------------------------------------------------------
inline float evaluateMetaBall(float r, float a, float b)
//------------------------------------------------------
{
	if (0 <= r && r <= b / 3.0)
	{
		return (a * (1.0 - (3.0 * r * r) / (b * b)));
	}
	else if (b / 3.0 <= r && r <= b)
	{
		return (((3.0 * a) / 2.0) * pow((1.0 - (r / b)), 2.0));
	}
	else //if (b <= r)
	{
		return (0);
	}
}


//--------------------------------------------------------
inline float evaluateSoftObject(float r, float a, float b)
//--------------------------------------------------------
{
	if (0 <= r && r <= b)
	{
		return (a * 
				(1.0 - 
						(( 4.0 * std::pow(r, 6)) / (9.0 * std::pow(b, 6))) + 
						((17.0 * std::pow(r, 4)) / (9.0 * std::pow(b, 4))) - 
						((22.0 * std::pow(r, 2)) / (9.0 * std::pow(b, 2)))));
	}
	else
	{
		return (0);
	}
}


//-------------------------------------------------------------------
inline float distance(const float aPoint1[3], const float aPoint2[3])
//-------------------------------------------------------------------
{
	float a(aPoint1[0] - aPoint2[0]);
	float b(aPoint1[1] - aPoint2[1]);
	float c(aPoint1[2] - aPoint2[2]);
	
	return (std::sqrt(a * a + b * b + c * c));

}


//------------------------------------------------------------------
inline void writeVoxelData(const std::string& aFileName,
						   const std::vector<float>& apVoxelDataSet)
//------------------------------------------------------------------
{
	writeVoxelData(aFileName.data(), apVoxelDataSet);
}

