/**
********************************************************************************
*
*	@file		ImplicitSurface.h
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


#ifndef IMPLICIT_SURFACE_H
#define IMPLICIT_SURFACE_H


//******************************************************************************
//	Include
//******************************************************************************
#include <vector>


//------------------------------------------------------------------------------
///	Type of density function.
//------------------------------------------------------------------------------
typedef enum DensityFunctionTypeTag
{
    SPHERE,
    BLOBBY_MOLECULE,	///< Blobby molecule, first created by Jim Blinn and modelled after electron density fields
    META_BALL,			///< Meta balls
    SOFT_OBJECT			///< Soft Objects, first created by the Wyvill brothers
} DensityFunctionType;


//------------------------------------------------------------------------------
///	Use the density function that creates spheres.
/**
*	@param r:	the distance of the voxel to the center of the control point
*	@return the density value corresponding to distance r
*/
//------------------------------------------------------------------------------
float evaluateSphere(float r);


//------------------------------------------------------------------------------
///	Use the density function that creates Blobby Molecules.
///	It was first created by Jim Blinn.
///	It is modelled after electron density fields.
/**
*	@param r:	the distance of the voxel to the center of the control point
*	@param a:	the height
*	@param b:	the standard deviation of the curve
*	@return the density value corresponding to distance r
*/
//------------------------------------------------------------------------------
float evaluateBlobbyMolecule(float r, float a, float b);


//--------------------------------------------------------------------------
///	Use the density function that creates Meta Balls.
/**
*	@param r:	the distance of the voxel to the center of the control point
*	@param a:	the scaling factor
*	@param b:	the maximum distance a control primitive contributes to the field
*	@return the density value corresponding to distance r
*/
//--------------------------------------------------------------------------
float evaluateMetaBall(float r, float a, float b);


//--------------------------------------------------------------------------
///	Use the density function that creates Soft Objects.
///	It was first created by the Wyvill brothers.
/**
*	@param r:	the distance of the voxel to the center of the control point
*	@param a:	the scaling factor
*	@param b:	the maximum distance a control primitive contributes to the field
*	@return the density value corresponding to distance r
*/
//--------------------------------------------------------------------------
float evaluateSoftObject(float r, float a, float b);


//--------------------------------------------------------------------------
///	Evaluate the density function.
/**
*   @param aDensityFunction:    the type of density function
*	@param r:	the distance of the voxel to the center of the control point
*	@param a:	the first parameter of the density function (default value: 0)
*	@param b:	the second parameter of the density function (default value: 0)
*	@return the density value corresponding to distance r
*/
//--------------------------------------------------------------------------
float evaluate(DensityFunctionType aDensityFunction,
        float r,
        float a = 0,
        float b = 0);


//--------------------------------------------------------------------------
///	The distance between two 3D points.
/**
*   @param aPoint1:    the first point
*   @param aPoint2:    the second point
*	@return the distance between aPoint1 and aPoint2
*/
//--------------------------------------------------------------------------
float distance(const float aPoint1[3], const float aPoint2[3]);


//--------------------------------------------------------------------------
///	Write a volume dataset into a file (binary RAW format).
/**
*   @param aFileName:    the name of the file
*   @param apVoxelDataSet:    the volume dataset to write
*/
//--------------------------------------------------------------------------
void writeVoxelData(const char* aFileName, const std::vector<float>& apVoxelDataSet);


//--------------------------------------------------------------------------
///	Write a volume dataset into a file (binary RAW format).
/**
*   @param aFileName:    the name of the file
*   @param apVoxelDataSet:    the volume dataset to write
*/
//--------------------------------------------------------------------------
void writeVoxelData(const std::string& aFileName, const std::vector<float>& apVoxelDataSet);


//--------------------------------------------------------------------------
///	Write a volume dataset into a file (binary RAW format).
/**
*   @param aDensityFunction:    the type of density function
*	@param a:	the first parameter of the density function
*	@param b:	the second parameter of the density function
*   @param apControlPointSet:    the set of control points
*   @param apVoxelDataSet:    the volume dataset to generate
*   @param aNumberOfVoxels:    the number of voxels in the volume dataset
*   @param aVoxelSize:    the size of voxels
*   @param aVolumeCentre:    the position in 3D of the centre of the volume dataset
*/
//--------------------------------------------------------------------------
void voxelise(DensityFunctionType aDensityFunction,
        float a,
        float b,
        const std::vector<float>& apControlPointSet,
        std::vector<float>& apVoxelDataSet,
        unsigned int aNumberOfVoxels[3],
        float aVoxelSize[3],
        float aVolumeCentre[3]);


//******************************************************************************
#include "ImplicitSurface.inl"


#endif // IMPLICIT_SURFACE_H
