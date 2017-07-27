/**
********************************************************************************
*
*	@file		test.cxx
*
*	@brief		Main program.
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
#include <iostream>
#include <cstdlib>
#include <time.h>

#ifndef IMPLICIT_SURFACE_H
#include "ImplicitSurface.h"
#endif


//-----------------------------
int main(int argc, char** argv)
//-----------------------------
{
    // Choose a density function
    DensityFunctionType density_function(META_BALL);
    float a(2);
    float b(3);

    // Set the volume data set
    std::vector<float> p_voxel_data;

	unsigned int p_number_of_voxel[3] = {512, 512, 512};
	float p_voxel_size[3] = {0.025, 0.025, 0.025};
	float p_centre[3] = {0.0, 0.0, 0.0};

    // Set the control points
    std::vector<float> p_control_point_set;

    // Add the control points
	float control_point_1[3] = {-2.0, 0.0, 0.0};
    p_control_point_set.push_back(control_point_1[0]);
    p_control_point_set.push_back(control_point_1[1]);
    p_control_point_set.push_back(control_point_1[2]);
    
	float control_point_2[3] = { 2.0, 0.0, 0.0};
    p_control_point_set.push_back(control_point_2[0]);
    p_control_point_set.push_back(control_point_2[1]);
    p_control_point_set.push_back(control_point_2[2]);

	float control_point_3[3] = { 0.0, 2.0, -2.0};
    p_control_point_set.push_back(control_point_3[0]);
    p_control_point_set.push_back(control_point_3[1]);
    p_control_point_set.push_back(control_point_3[2]);

	/*float control_point_4[3] = { 0.0, -2.0, 2.0};
    p_control_point_set.push_back(control_point_4[0]);
    p_control_point_set.push_back(control_point_4[1]);
    p_control_point_set.push_back(control_point_4[2]);
	*/
    // Start the timer
    clock_t start(clock());

    // Generate the density field
    voxelise(density_function,
            a,
            b,
            p_control_point_set,
            p_voxel_data,
            p_number_of_voxel,
            p_voxel_size,
            p_centre);

    // Stop the timer
    clock_t end(clock());
    
    // Get the duration of the computations
	float number_of_seconds(float(end - start) / CLOCKS_PER_SEC);

    // Display the computing time
    std::cout << "Computing time:\t" << number_of_seconds << " seconds." << std::endl;
    
    // Save the data in a file
    writeVoxelData("output.raw", p_voxel_data);

    return (EXIT_SUCCESS);
}
