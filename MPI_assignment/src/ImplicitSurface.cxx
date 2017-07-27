/**
********************************************************************************
*
*	@file		ImplicitSurface.cxx
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
#include <fstream>
#include <iostream>
#include <cstdlib>

#ifndef IMPLICIT_SURFACE_H
#include "ImplicitSurface.h"
#endif


//******************************************************************************
//	Name space
//******************************************************************************
//using namespace Graphics;


//******************************************************************************
//	Constant variables
//******************************************************************************


//******************************************************************************
//	Global variables
//******************************************************************************


//******************************************************************************
//	Function declaration
//******************************************************************************


//--------------------------------------------------------
void voxelise(DensityFunctionType aDensityFunction,
              float a,
              float b,
              const std::vector<float>& apControlPointSet,
              std::vector<float>& apVoxelDataSet,
              unsigned int aVolumeSize[3],
              float aVoxelSize[3],
              float aVolumeCentre[3])
//--------------------------------------------------------
{
    // Clear the voxel data
    apVoxelDataSet.clear();
    
    // Set the size of the buffer is necessary
    unsigned int number_of_voxels(aVolumeSize[0] * aVolumeSize[1] * aVolumeSize[2]);
    if (apVoxelDataSet.size() != number_of_voxels)
    {
        // Resize the buffer
        apVoxelDataSet.resize(number_of_voxels, 0);
    }
    
    // Compute the half size of a voxel
    float half_voxel_size[3] = {
            aVoxelSize[0] / 2.0f,
			aVoxelSize[1] / 2.0f,
			aVoxelSize[2] / 2.0f
    };

    // Compute the half size of the volume
	float half_volume_size[3] = {
            half_voxel_size[0] * aVolumeSize[0],
			half_voxel_size[1] * aVolumeSize[1],
			half_voxel_size[2] * aVolumeSize[2]
    };

    // Compute the position of the centre of the first voxel
	float offset[3] = {
        aVolumeCentre[0] - half_volume_size[0] + half_voxel_size[0],
        aVolumeCentre[1] - half_volume_size[1] + half_voxel_size[1],
        aVolumeCentre[2] - half_volume_size[2] + half_voxel_size[2]
    };

    // Process all the slides
	for (unsigned int z(0); z < aVolumeSize[2]; ++z)
	{
        // Store the voxel centre
        float voxel_center[3];
        
        // Update the centre of the current voxel
		voxel_center[2] = offset[2] + z * aVoxelSize[2];

        // Process all the rows
		for (unsigned int y(0); y < aVolumeSize[1]; ++y)
		{
            // Update the centre of the current voxel
			voxel_center[1] = offset[1] + y * aVoxelSize[1];

            // Process all the colums
			for (unsigned int x(0); x < aVolumeSize[0]; ++x)
			{
                // Value of the current voxel
				float voxel_value(0);

			    // Update the centre of the current voxel
                voxel_center[0] = offset[0] + x * aVoxelSize[0];

				// Process all the points
				for (std::vector<float>::const_iterator point_ite(apControlPointSet.begin());
						point_ite != apControlPointSet.end();
						point_ite += 3)
				{
                    // Compute the distance between the control point and the centre of the current voxel
                	float r(distance(voxel_center, &(*point_ite)));
					voxel_value += evaluate(aDensityFunction, r, a, b);
				}
                
                // Compute the voxel index
                unsigned int voxel_index(z * aVolumeSize[0] * aVolumeSize[1] + y * aVolumeSize[0] + x);
                
                // Set the value of the current voxel
                apVoxelDataSet[voxel_index] = voxel_value;
			}
		}
	}
}


//----------------------------------------------------------------------------------
void writeVoxelData(const char* aFileName, const std::vector<float>& apVoxelDataSet)
//----------------------------------------------------------------------------------
{
    // Open the file
    std::ofstream output_file;
    output_file.open(aFileName, std::ios::out | std::ios::trunc | std::ios::binary);
    
    // The file is not open
    if (!output_file.is_open())
	{
		std::cerr << "Cannot write the file (" << aFileName << ".)" << std::endl;
		exit(EXIT_FAILURE);
	}
    
    // Process all the voxel
    for (std::vector<float>::const_iterator voxel_ite(apVoxelDataSet.begin());
            voxel_ite != apVoxelDataSet.end();
            ++voxel_ite)
    {
    	output_file.write(reinterpret_cast<const char*>(&(*voxel_ite)), sizeof(float));
    }
    
    // Close the file
    output_file.close();
}
