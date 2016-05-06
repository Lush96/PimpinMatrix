package com.mobiledev.topimpamatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by larspmayrand on 4/30/16.
 */
public class LinearDictionary {

    private ArrayList<Definition> definitions;

    private HashMap<String, String> dictionary;

    private String[] unparsedDictionary = new String[] {
            "Adjoint:  Transpose of a square matrix's cofactor matrix.",
            "Affine transformation: Linear transformation which preserves points, straight lines, and planes.",
            "Associative: $(AB)C = A(BC).$",
            "Augmented matrix: A matrix obtained by appending the columns of two given matrices.",
            "Band matrix: A sparse matrix whose non-zero entries form a diagonal band.",
            "Basis: A list of linearly independent vectors which span an entire subspace.",
            "Block matrix: A submatrix from a larger matrix.",
            "Cayley-Hamilton Theorem: $p(λ) = $det$(A − λI)$ has $p(A)$ = zero matrix.",
            "Characteristic equation: det$(A − λI) = 0.$ The $n$ roots are the eigenvalues of $A$.",
            "Circulant matrix: A Toeplitz matrix where each row vector is rotated one element to the right relative to the preceding row vector.",
            "Cofactor: The product of the determinant of the submatrix obatined by removing row i and column j and $(−1)^{i+j}.$",
            "Column space: Span of column vectors.",
            "Commuting matrices: $AB = BA.$ If diagonalizable, they share $n$ eigenvectors.",
            "Complex conjugate: The reflection of a complex number about the real axis.",
            "Cross product: The cross product of two vectors gives a third vector orthogonal to the first two with magnitude equal to determinant.",
            "Confusion matrix: A table visualizing performance of an algorithm.",
            "Determinant: The factor by which a square matrix scales a the unit area.",
            "Diagonal matrix: A matrix with nonzero elements only on its main diagonal.",
            "Dimension: Number of vectors in a basis.",
            "Distributive law: $A(B + C) = AB + AC.$",
            "Dot product: Multiplication defined on vectors.",
            "Eigenvalue: If $Mv = λv,$ λ is an eigenvalue and v is an eigenvector of matrix M.",
            "Eigenvector: If $Mv = λv,$ λ is an eigenvalue and v is an eigenvector of matrix M.",
            "Eigenvalue problem: Any problem that takes the form $T(O) = λO$ where $T$ is a transformation, $O$ is an object, and $λ$ is a scalar.",
            "Elimination: A sequence of row operations that reduces a matrix to a reduced form, typically a triangular or row reduced echlon form.",
            "Free columns: Columns without pivots; combinations of earlier columns.",
            "Full rank: Matrix whose rank is as large as possible for a matrix of its dimension.",
            "Gauss-Jordan method: Finding a matrix's inverse by row operations.",
            "Gram-Schmidt process: Process which to orthogonalize a matrix using projections.",
            "Hankel matrix: A square matrix where each ascending skew-diagonal from left to right is constant.",
            "Hessenberg matrix: Triangular matrix with one extra nonzero adjacent diagonal.",
            "Identity matrix: A square matrix with 1s along its main diagonal.",
            "Indefinite matrix. A symmetric matrix with eigenvalues of both signs (+ and −).",
            "Independent vectors: A list of vectors where no vector can be built from a linearly combination of any others.",
            "Inverse matrix: The matrix that undoes a matrix's transformation. Must be square and nonsingular.",
            "Iterative method. A sequence of steps intended to approach the desired solution.",
            "Linearly dependent: A list of vectors where at least one vector can be made from a combination of the others.",
            "Matrix multiplication: Method of multiplying matrices.",
            "Markov matrix: Matrix where all entries are positive and each column sum is 1 and the largest eigenvalue is $λ = 1.$",
            "Network: A directed graph that has constants associated with the edges.",
            "Nilpotent matrix: Matrix where the only eigenvalues are λ = 0.",
            "Nullspace: Vectors that map to zero. Solutions to $Ax = 0.$",
            "Orthogonal matrix: Square matrix with orthonormal columns.",
            "Outer product: Tensor product of two vectors.",
            "Pascal matrix: The symmetric matrix with binomial entries.", // crashed here
            "Perpendicular: Vectors have zero dot product.",
            "Pivot columns: Columns that contain pivots after row reduction; not combinations of earlier columns. The pivot columns are a basis for the column space.",
            "Pivot: The diagonal entry (first nonzero) when a row is used in elimination.",
            "Polar decomposition: $A = QH.$ Orthogonal $Q,$ positive (semi)definite $H$.",
            "Positive definite: Symmetric matrix with positive eigenvalues and positive pivots.",
            "Rotation matrix: Matrix which rotates vectors.",
            "Row reduced echelon form: The first nonzero entry (the pivot) in each row comes after the pivot in the previous row. All zero rows come last.",
            "Row space: Image of the row vectors.",
            "Semidefinite matrix: A matrix that is a Gram matrix of some set of vectors.",
            "Similar matrices: A and B are similar if there is a invertible matrix $P$ where $P^(-1s)AP = B.$",
            "Singular: A square matrix that has no inverse: det$(A) = 0.$",
            "Skew-symmetric: A matrix equal to its negative transpose.",
            "Solvable system: $Ax = b$ is solvable if the right side b is in the column space of $A.$",
            "Sparse matrix: A matrix where most elements are zero.",
            "Stiffness matrix: If $x$ gives the movements of the nodes in a discrete structure, $K_x$ gives the internal forces. Often $K = ATCA$ where $C$ contains spring constants from Hooke’s Law and $A_x = stretching (strains) from the movements $x.$",
            "Subspace: A vector space inside another vector space, including itself and the zero vector.",
            "Symmetric: A matrix equal to its own transpose.",
            "Toeplitz matrix: Constant-diagonal matrix.",
            "Trace: Sum of diagonal entries.",
            "Tridiagonal matrix: A band matrix that has non-zero elements only on the main diagonal.",
            "Unitary matrix: A matrix equal whose conjugate transpose is equal to its inverse.",
            "Vandermonde matrix: A matrix whose rows are geometric progressions.",
            "Vector addition: $v + w = (v1 + w1, . . . , vn + wn).$",
            "Vector space: Basically a thing that respects adding and scaling. There's eight formal axioms though." };

//    public LinearDictionary(Context context) {
//        InputStream input = context.getResources().openRawResource(+ R.drawable.linear_dictionary);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//
//        String line = null;
//
//        while ((line = reader.readLine()) != null) {
//            buf.append(str + "\n" );
//        }
//        while (input.hasNextLine()) {
//            String line = input.readLine();
//            for (int i = 0; i < line.length(); i++){
//                if (line.charAt(i) == ':') {
//                    definitions.add(new Definition(line.substring(0, i), line.substring(i + 1, line.length())));
//                    dictionary.put(line.substring(0, i), "" + line.substring(i + 1, line.length()));
//                }
//            }
//        }
//        input.close();
//    }

    public LinearDictionary() {
        definitions = new ArrayList<Definition>();
//        dictionary = new HashMap<String, String>();
        for (int i = 0; i < unparsedDictionary.length; i++) {
            for (int j = 0; j < unparsedDictionary[i].length(); j++) {
                if (unparsedDictionary[i].charAt(j) == ':') {
                    definitions.add(new Definition(unparsedDictionary[i].substring(0, j), unparsedDictionary[i].substring(j + 1, unparsedDictionary[i].length())));
//                    dictionary.put(unparsedDictionary[i].substring(0, j), "" + unparsedDictionary[i].substring(j + 1, unparsedDictionary[i].length()));
                }
            }
        }
    }

    public ArrayList<Definition> getDefinitions() {
        return definitions;
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

}
