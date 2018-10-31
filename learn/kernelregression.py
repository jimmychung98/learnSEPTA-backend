#!/venv/bin/python3
#
# License: BSD 3 clause

import numpy as np

from sklearn.metrics.pairwise import pairwise_kernels
from sklearn.base import BaseEstimator, RegressorMixin


class KernelRegression(BaseEstimator, RegressorMixin):
	"""
	Implementation of the Nadaraya-Watson Kernel Regression

	See: https://github.com/jmetzen/kernel_regression/blob/master/kernel_regression.py
	"""

	def __init__(self, kernel='rbf', gamma=None):
		self.kernel = kernel
		self.gamma = gamma

	